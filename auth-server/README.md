http://localhost:9001/oauth2/authorize?response_type=code&client_id=rentallo-app&redirect_uri=http://localhost:4200&scope=management


curl localhost:9001/oauth2/token \
-H"Content-type: application/x-www-form-urlencoded" \
-d"grant_type=authorization_code" \
-d"redirect_uri=http://localhost:4200" \
-d"code=TyYiQtIC0FV0lOV3Exi7-ZbX2GHbDFAGiifcxtgKQWBWHXC7547jkebVS2RIv_hTI5gpo7JjqZrGZs1iVrX4sYgFtJIXcj1x-nrV7Feis3GWRiNl8qJPqUuiBRNIEVvA" \
-u rentallo-app:secret