
# FILE 1: definition.yaml
$f1 = @"
`$kind: collection
name: FocusLearn API
description: 'REST API for the FocusLearn platform. Set the base_url environment variable to http://localhost:8081 before sending requests.'
variables:
  userId: ''
  enrollmentId: ''
  profileId: ''
"@
[System.IO.File]::WriteAllText('C:\Users\Screte\Downloads\FocusLearn\postman\collections\FocusLearn API\.resources\definition.yaml', $f1, [System.Text.Encoding]::UTF8)
Write-Host "FILE 1 done"

# FILE 2: Get All Users
$f2 = @"
`$kind: http-request
method: GET
url: '{{base_url}}/api/users'
order: 1000
scripts:
  - type: afterResponse
    language: text/javascript
    code: |-
      pm.test("Status code is 200", function () {
          pm.response.to.have.status(200);
      });
      pm.test("Response is an array", function () {
          const json = pm.response.json();
          pm.expect(json).to.be.an("array");
      });
      pm.test("Each user has required fields", function () {
          const json = pm.response.json();
          json.forEach(function(user) {
              pm.expect(user).to.have.property("userID").that.is.a("number");
              pm.expect(user).to.have.property("username").that.is.a("string");
              pm.expect(user).to.have.property("email").that.is.a("string");
              pm.expect(user).to.have.property("role").that.is.a("string");
          });
      });
"@
[System.IO.File]::WriteAllText('C:\Users\Screte\Downloads\FocusLearn\postman\collections\FocusLearn API\Users\Get All Users.request.yaml', $f2, [System.Text.Encoding]::UTF8)
Write-Host "FILE 2 done"

# FILE 3: Get User by ID
$f3 = @"
`$kind: http-request
method: GET
url: '{{base_url}}/api/users/:id'
order: 2000
pathVariables:
  - key: id
    value: '{{userId}}'
scripts:
  - type: afterResponse
    language: text/javascript
    code: |-
      pm.test("Status code is 200", function () {
          pm.response.to.have.status(200);
      });
      pm.test("User schema is valid", function () {
          const user = pm.response.json();
          pm.expect(user).to.have.property("userID").that.is.a("number");
          pm.expect(user).to.have.property("username").that.is.a("string");
          pm.expect(user).to.have.property("email").that.is.a("string");
          pm.expect(user).to.have.property("role").that.is.a("string");
          pm.expect(user).to.have.property("createdAt");
          pm.expect(user).to.not.have.property("passwordHash");
      });
"@
[System.IO.File]::WriteAllText('C:\Users\Screte\Downloads\FocusLearn\postman\collections\FocusLearn API\Users\Get User by ID.request.yaml', $f3, [System.Text.Encoding]::UTF8)
Write-Host "FILE 3 done"

# FILE 4: Create User
$f4 = @"
`$kind: http-request
method: POST
url: '{{base_url}}/api/users'
order: 3000
headers:
  Content-Type: application/json
body:
  type: json
  content: |-
    {
      "username": "johndoe",
      "email": "john@example.com",
      "passwordHash": "secret123",
      "role": "student"
    }
scripts:
  - type: afterResponse
    language: text/javascript
    code: |-
      pm.test("Status code is 200", function () {
          pm.response.to.have.status(200);
      });
      pm.test("Created user has required fields", function () {
          const user = pm.response.json();
          pm.expect(user).to.have.property("userID").that.is.a("number");
          pm.expect(user).to.have.property("username").that.is.a("string");
          pm.expect(user).to.have.property("email").that.is.a("string");
          pm.expect(user).to.have.property("role").that.is.a("string");
          pm.expect(user).to.not.have.property("passwordHash");
      });
      pm.test("userId saved for chaining", function () {
          const user = pm.response.json();
          pm.expect(user.userID).to.be.a("number");
          pm.collectionVariables.set("userId", user.userID);
      });
"@
[System.IO.File]::WriteAllText('C:\Users\Screte\Downloads\FocusLearn\postman\collections\FocusLearn API\Users\Create User.request.yaml', $f4, [System.Text.Encoding]::UTF8)
Write-Host "FILE 4 done"

# FILE 5: Update User
$f5 = @"
`$kind: http-request
method: PUT
url: '{{base_url}}/api/users/:id'
order: 4000
pathVariables:
  - key: id
    value: '{{userId}}'
headers:
  Content-Type: application/json
body:
  type: json
  content: |-
    {
      "username": "johndoe_updated",
      "email": "john_updated@example.com",
      "passwordHash": "newpassword123",
      "role": "student"
    }
scripts:
  - type: afterResponse
    language: text/javascript
    code: |-
      pm.test("Status code is 200", function () {
          pm.response.to.have.status(200);
      });
      pm.test("Updated user has correct fields", function () {
          const user = pm.response.json();
          pm.expect(user).to.have.property("userID").that.is.a("number");
          pm.expect(user.username).to.equal("johndoe_updated");
          pm.expect(user.email).to.equal("john_updated@example.com");
          pm.expect(user).to.not.have.property("passwordHash");
      });
"@
[System.IO.File]::WriteAllText('C:\Users\Screte\Downloads\FocusLearn\postman\collections\FocusLearn API\Users\Update User.request.yaml', $f5, [System.Text.Encoding]::UTF8)
Write-Host "FILE 5 done"

# FILE 6: Delete User
$f6 = @"
`$kind: http-request
method: DELETE
url: '{{base_url}}/api/users/:id'
order: 5000
pathVariables:
  - key: id
    value: '{{userId}}'
scripts:
  - type: afterResponse
    language: text/javascript
    code: |-
      pm.test("Status code is 204", function () {
          pm.response.to.have.status(204);
      });
"@
[System.IO.File]::WriteAllText('C:\Users\Screte\Downloads\FocusLearn\postman\collections\FocusLearn API\Users\Delete User.request.yaml', $f6, [System.Text.Encoding]::UTF8)
Write-Host "FILE 6 done"

# FILE 7: Get All Enrollments
$f7 = @"
`$kind: http-request
method: GET
url: '{{base_url}}/api/enrollments'
order: 1000
scripts:
  - type: afterResponse
    language: text/javascript
    code: |-
      pm.test("Status code is 200", function () {
          pm.response.to.have.status(200);
      });
      pm.test("Response is an array", function () {
          const json = pm.response.json();
          pm.expect(json).to.be.an("array");
      });
      pm.test("Each enrollment has required fields", function () {
          const json = pm.response.json();
          json.forEach(function(enrollment) {
              pm.expect(enrollment).to.have.property("enrollmentID").that.is.a("number");
              pm.expect(enrollment).to.have.property("courseID").that.is.a("number");
              pm.expect(enrollment).to.have.property("user");
          });
      });
"@
[System.IO.File]::WriteAllText('C:\Users\Screte\Downloads\FocusLearn\postman\collections\FocusLearn API\Enrollments\Get All Enrollments.request.yaml', $f7, [System.Text.Encoding]::UTF8)
Write-Host "FILE 7 done"

# FILE 8: Get Enrollment by ID
$f8 = @"
`$kind: http-request
method: GET
url: '{{base_url}}/api/enrollments/:id'
order: 2000
pathVariables:
  - key: id
    value: '{{enrollmentId}}'
scripts:
  - type: afterResponse
    language: text/javascript
    code: |-
      pm.test("Status code is 200", function () {
          pm.response.to.have.status(200);
      });
      pm.test("Enrollment schema is valid", function () {
          const enrollment = pm.response.json();
          pm.expect(enrollment).to.have.property("enrollmentID").that.is.a("number");
          pm.expect(enrollment).to.have.property("courseID").that.is.a("number");
          pm.expect(enrollment).to.have.property("user");
          pm.expect(enrollment).to.have.property("dateEnrolled");
      });
"@
[System.IO.File]::WriteAllText('C:\Users\Screte\Downloads\FocusLearn\postman\collections\FocusLearn API\Enrollments\Get Enrollment by ID.request.yaml', $f8, [System.Text.Encoding]::UTF8)
Write-Host "FILE 8 done"

# FILE 9: Create Enrollment
$f9 = @"
`$kind: http-request
method: POST
url: '{{base_url}}/api/enrollments'
order: 3000
headers:
  Content-Type: application/json
body:
  type: json
  content: |-
    {
      "user": { "userID": {{userId}} },
      "courseID": 1
    }
scripts:
  - type: afterResponse
    language: text/javascript
    code: |-
      pm.test("Status code is 200", function () {
          pm.response.to.have.status(200);
      });
      pm.test("Created enrollment has required fields", function () {
          const enrollment = pm.response.json();
          pm.expect(enrollment).to.have.property("enrollmentID").that.is.a("number");
          pm.expect(enrollment).to.have.property("courseID").that.is.a("number");
          pm.expect(enrollment).to.have.property("user");
      });
      pm.test("enrollmentId saved for chaining", function () {
          const enrollment = pm.response.json();
          pm.expect(enrollment.enrollmentID).to.be.a("number");
          pm.collectionVariables.set("enrollmentId", enrollment.enrollmentID);
      });
"@
[System.IO.File]::WriteAllText('C:\Users\Screte\Downloads\FocusLearn\postman\collections\FocusLearn API\Enrollments\Create Enrollment.request.yaml', $f9, [System.Text.Encoding]::UTF8)
Write-Host "FILE 9 done"

# FILE 10: Update Enrollment
$f10 = @"
`$kind: http-request
method: PUT
url: '{{base_url}}/api/enrollments/:id'
order: 4000
pathVariables:
  - key: id
    value: '{{enrollmentId}}'
headers:
  Content-Type: application/json
body:
  type: json
  content: |-
    {
      "user": { "userID": {{userId}} },
      "courseID": 2
    }
scripts:
  - type: afterResponse
    language: text/javascript
    code: |-
      pm.test("Status code is 200", function () {
          pm.response.to.have.status(200);
      });
      pm.test("Updated enrollment has correct fields", function () {
          const enrollment = pm.response.json();
          pm.expect(enrollment).to.have.property("enrollmentID").that.is.a("number");
          pm.expect(enrollment.courseID).to.equal(2);
      });
"@
[System.IO.File]::WriteAllText('C:\Users\Screte\Downloads\FocusLearn\postman\collections\FocusLearn API\Enrollments\Update Enrollment.request.yaml', $f10, [System.Text.Encoding]::UTF8)
Write-Host "FILE 10 done"

# FILE 11: Delete Enrollment
$f11 = @"
`$kind: http-request
method: DELETE
url: '{{base_url}}/api/enrollments/:id'
order: 5000
pathVariables:
  - key: id
    value: '{{enrollmentId}}'
scripts:
  - type: afterResponse
    language: text/javascript
    code: |-
      pm.test("Status code is 204", function () {
          pm.response.to.have.status(204);
      });
"@
[System.IO.File]::WriteAllText('C:\Users\Screte\Downloads\FocusLearn\postman\collections\FocusLearn API\Enrollments\Delete Enrollment.request.yaml', $f11, [System.Text.Encoding]::UTF8)
Write-Host "FILE 11 done"

# FILE 12: Get All Profiles
$f12 = @"
`$kind: http-request
method: GET
url: '{{base_url}}/api/accessibility-profiles'
order: 1000
scripts:
  - type: afterResponse
    language: text/javascript
    code: |-
      pm.test("Status code is 200", function () {
          pm.response.to.have.status(200);
      });
      pm.test("Response is an array", function () {
          const json = pm.response.json();
          pm.expect(json).to.be.an("array");
      });
      pm.test("Each profile has required fields", function () {
          const json = pm.response.json();
          json.forEach(function(profile) {
              pm.expect(profile).to.have.property("profileID").that.is.a("number");
              pm.expect(profile).to.have.property("fontFamily");
              pm.expect(profile).to.have.property("fontSize");
              pm.expect(profile).to.have.property("colorTheme");
          });
      });
"@
[System.IO.File]::WriteAllText('C:\Users\Screte\Downloads\FocusLearn\postman\collections\FocusLearn API\Accessibility Profiles\Get All Profiles.request.yaml', $f12, [System.Text.Encoding]::UTF8)
Write-Host "FILE 12 done"

# FILE 13: Get Profile by ID
$f13 = @"
`$kind: http-request
method: GET
url: '{{base_url}}/api/accessibility-profiles/:id'
order: 2000
pathVariables:
  - key: id
    value: '{{profileId}}'
scripts:
  - type: afterResponse
    language: text/javascript
    code: |-
      pm.test("Status code is 200", function () {
          pm.response.to.have.status(200);
      });
      pm.test("Profile schema is valid", function () {
          const profile = pm.response.json();
          pm.expect(profile).to.have.property("profileID").that.is.a("number");
          pm.expect(profile).to.have.property("fontFamily");
          pm.expect(profile).to.have.property("fontSize");
          pm.expect(profile).to.have.property("colorTheme");
          pm.expect(profile).to.have.property("focusModeDefault");
          pm.expect(profile).to.have.property("ttsSpeed");
          pm.expect(profile).to.have.property("lineSpacing");
          pm.expect(profile).to.have.property("letterSpacing");
          pm.expect(profile).to.not.have.property("user");
      });
"@
[System.IO.File]::WriteAllText('C:\Users\Screte\Downloads\FocusLearn\postman\collections\FocusLearn API\Accessibility Profiles\Get Profile by ID.request.yaml', $f13, [System.Text.Encoding]::UTF8)
Write-Host "FILE 13 done"

# FILE 14: Create Profile
$f14 = @"
`$kind: http-request
method: POST
url: '{{base_url}}/api/accessibility-profiles'
order: 3000
headers:
  Content-Type: application/json
body:
  type: json
  content: |-
    {
      "userID": {{userId}},
      "fontFamily": "Arial",
      "fontSize": 16,
      "colorTheme": "light",
      "focusModeDefault": false,
      "ttsSpeed": 1.0,
      "lineSpacing": 1.0,
      "letterSpacing": 0.0
    }
scripts:
  - type: afterResponse
    language: text/javascript
    code: |-
      pm.test("Status code is 200", function () {
          pm.response.to.have.status(200);
      });
      pm.test("Created profile has required fields", function () {
          const profile = pm.response.json();
          pm.expect(profile).to.have.property("profileID").that.is.a("number");
          pm.expect(profile).to.have.property("fontFamily").that.is.a("string");
          pm.expect(profile).to.have.property("colorTheme").that.is.a("string");
          pm.expect(profile).to.not.have.property("user");
      });
      pm.test("profileId saved for chaining", function () {
          const profile = pm.response.json();
          pm.expect(profile.profileID).to.be.a("number");
          pm.collectionVariables.set("profileId", profile.profileID);
      });
"@
[System.IO.File]::WriteAllText('C:\Users\Screte\Downloads\FocusLearn\postman\collections\FocusLearn API\Accessibility Profiles\Create Profile.request.yaml', $f14, [System.Text.Encoding]::UTF8)
Write-Host "FILE 14 done"

# FILE 15: Update Profile
$f15 = @"
`$kind: http-request
method: PUT
url: '{{base_url}}/api/accessibility-profiles/:id'
order: 4000
pathVariables:
  - key: id
    value: '{{profileId}}'
headers:
  Content-Type: application/json
body:
  type: json
  content: |-
    {
      "userID": {{userId}},
      "fontFamily": "OpenDyslexic",
      "fontSize": 18,
      "colorTheme": "dark",
      "focusModeDefault": true,
      "ttsSpeed": 1.25,
      "lineSpacing": 1.5,
      "letterSpacing": 0.05
    }
scripts:
  - type: afterResponse
    language: text/javascript
    code: |-
      pm.test("Status code is 200", function () {
          pm.response.to.have.status(200);
      });
      pm.test("Updated profile has correct values", function () {
          const profile = pm.response.json();
          pm.expect(profile.fontFamily).to.equal("OpenDyslexic");
          pm.expect(profile.colorTheme).to.equal("dark");
          pm.expect(profile.focusModeDefault).to.equal(true);
      });
"@
[System.IO.File]::WriteAllText('C:\Users\Screte\Downloads\FocusLearn\postman\collections\FocusLearn API\Accessibility Profiles\Update Profile.request.yaml', $f15, [System.Text.Encoding]::UTF8)
Write-Host "FILE 15 done"

# FILE 16: Delete Profile
$f16 = @"
`$kind: http-request
method: DELETE
url: '{{base_url}}/api/accessibility-profiles/:id'
order: 5000
pathVariables:
  - key: id
    value: '{{profileId}}'
scripts:
  - type: afterResponse
    language: text/javascript
    code: |-
      pm.test("Status code is 204", function () {
          pm.response.to.have.status(204);
      });
"@
[System.IO.File]::WriteAllText('C:\Users\Screte\Downloads\FocusLearn\postman\collections\FocusLearn API\Accessibility Profiles\Delete Profile.request.yaml', $f16, [System.Text.Encoding]::UTF8)
Write-Host "FILE 16 done"

Write-Host "ALL FILES WRITTEN"
