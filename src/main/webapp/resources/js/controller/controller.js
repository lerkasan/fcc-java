'use strict';

// ************  Home Page  ******************
myApp.controller('homeController', function ($scope, $http) {
});

// ************  Register Page  ******************
myApp.controller('registerController', function ($scope, $http) {

    $scope.validate = function() {

        $scope.emailValidationError = "";
        $scope.passwordValidationError = "";
        $scope.usernameValidationError = "";
        var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        var illegalUsernameChars = /\W/;

        /*   if (($scope.username == '') || ($scope.username == null)) {
         $scope.usernameValidationError = "Username is empty";
         } */
        if ($scope.account == null) {
            $scope.account = {};
        }

      /*  if (($scope.account.password == '') || ($scope.account.password == null)) {
            $scope.passwordValidationError = "Password is empty";
        } */

     /*   if (($scope.account.email == '') || ($scope.account.email == null)) {
            $scope.emailValidationError = "E-mail is empty";
        } */

        if (illegalUsernameChars.test($scope.account.username)) {
            $scope.usernameValidationError = "Please use only letters, numbers and underscopes in username";
        }

        if ($scope.account.password != $scope.account.password2) {
            $scope.passwordValidationError = "Passwords aren't equal";
        }

      /*  if (!re.test($scope.account.email)) {
            $scope.emailValidationError = "Wrong e-mail format";
        } */

        $scope.submit();
        /*  $http({
         url: '#/register',
         method: "POST",
         data: JSON.stringify({application:app, from:d1, to:d2}),
         headers: {'Content-Type': 'application/json'}
         }).success(function (data, status, headers, config) {
         $scope.users = data.users; // assign  $scope.persons here as promise is resolved here
         }).error(function (data, status, headers, config) {
         $scope.status = status + ' ' + headers;
         });*/

        // $scope.processForm = function() {




    /*    $http({
            method: 'GET',
            url: '/someUrl'
        }).then(function successCallback(response) {
            // this callback will be called asynchronously
            // when the response is available
        }, function errorCallback(response) {
            // called asynchronously if an error occurs
            // or server returns response with an error status.
        });*/

     //   $http.post('#/register', $scope.account) .success(function(data) { ... });

    }

    $scope.submit = function() {

       /* var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content");
        $http.defaults.headers.common[header] = token; */

        $http({
            method: 'POST',
            url: '#/register',
            data: $.param($scope.account),  // pass in data as strings
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}  // set the headers so angular passing info as form data (not request payload)

        })
            .success(function (data, status, headers, config) {
                //console.log(data);

                //if (!data.success) {
                // if not successful, bind errors to error variables
                /*   $scope.errorUsername = data.errors.username;
                 $scope.errorEmail = data.errors.email;*/
                //  $scope.statusCode = status;
                //} else {
                // if successful, bind success message to message
                //    $scope.message = data.message;
                //}
            })
            .error(function (data, status, headers, config) {
                /*   $scope.errorUsername = data.errors.username;
                 $scope.errorEmail = data.errors.email;*/
                $scope.statusCode = status;
                // called asynchronously if an error occurs
                // or server returns response with an error status.
            });
    };

});

myApp.controller('signInController1', function ($scope, $http) {
    $scope.passwordValidationError = "Passwords aren't equal";
});

// ************  Articles Page  ******************
myApp.controller('contactsController', function ($scope, $http) {
});

// ************  Info Page  ******************
myApp.controller('infoController', function ($scope, $http) {
});


// ************ ADMIN:  Admin Home Page  ******************
myAdmin.controller('adminHomeController', function ($scope, $http) {
});

// ************ ADMIN:  Admin Create Page  ******************
myAdmin.controller('adminCreateController', function ($scope, $http) {
});

// ************ ADMIN:  Admin Update Page  ******************
myAdmin.controller('adminUpdateController', function ($scope, $http) {
});

// ************ ADMIN:  Admin Delete Page  ******************
myAdmin.controller('adminDeleteController', function ($scope, $http) {
});

// ************ ADMIN:  Admin View Page  ******************
myAdmin.controller('adminViewController', function ($scope, $http) {
});

