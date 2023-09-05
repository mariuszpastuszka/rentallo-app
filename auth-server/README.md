http://localhost:9001/oauth2/authorize?response_type=code&client_id=rentallo-app&redirect_uri=http://localhost:4200&scope=management


curl localhost:9001/oauth2/token \
-H"Content-type: application/x-www-form-urlencoded" \
-d"grant_type=authorization_code" \
-d"redirect_uri=http://localhost:4200" \
-d"code=$code" \
-u rentallo-app:secret

curl localhost:8080/api/cars \
-H"Content-type: application/json" \
-H"Authorization: Bearer $token" -v
