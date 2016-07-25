'use strict';

// ************  Home Page  ******************
myApp.controller('homeController', function ($scope, $http) {

    $scope.validateLogin = function () {

    $http({
        method: 'POST',
        url: '/home',
        //data: jsonData,
        data: $.param($scope.login),  // pass in data as strings
        headers: {'Content-Type': 'application/x-www-form-urlencoded'}  // set the headers so angular passing info as form data (not request payload)
    })
        .then(function (response) {
            $scope.statusCode = response.status;
            $scope.data = response.data;
            if (response.status == 200) {
                alert('Successful login');
            }
        }, function (response) {
            $scope.statusCode = response.status;
            if ((response.status == 405) || (response.status == 500) || (response.status == 401)) {
                alert('Error occured during login. '+'HTTP error code '+response.status);
            }
        });
    }
});

// ************  Register Page  ******************
myApp.controller('registerController', function ($scope, $http) {

    $scope.validateRegistration = function () {

        $scope.emailValidationError = "";
        $scope.passwordValidationError = "";
        $scope.usernameValidationError = "";
        $scope.valid = true;
        var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        var illegalUsernameChars = /\W/;


        if ($scope.account == null) {
            $scope.account = {};
        }

        if (illegalUsernameChars.test($scope.account.username)) {
            $scope.usernameValidationError = "Please use only letters, numbers and underscopes in username";
            $scope.valid = false;
        }

        if ($scope.valid) {
            $scope.submit('/register', 'Registration was successful', 'Error occured during registration');
        }

        /*   if (($scope.username == '') || ($scope.username == null)) {
         $scope.usernameValidationError = "Username is empty";
         }

         if (($scope.account.password == '') || ($scope.account.password == null)) {
         $scope.passwordValidationError = "Password is empty";
         }

         if (($scope.account.email == '') || ($scope.account.email == null)) {
         $scope.emailValidationError = "E-mail is empty";
         }

        if (!re.test($scope.account.email)) {
            $scope.emailValidationError = "Wrong email format";
            $scope.valid = false;
        }

        if ($scope.account.password != $scope.account.password2) {
            $scope.passwordValidationError = "Passwords aren't equal";
            $scope.valid = false;
        } */
    }

    $scope.submit = function (urlPath, successMsg, errorMsg) {

        // var token = $("meta[name='_csrf']").attr("content");
        // var header = $("meta[name='_csrf_header']").attr("content");

        $http({
            method: 'POST',
            url: urlPath,
            //url: '#/register',
            data: $.param($scope.account),  // pass in data as strings
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}  // set the headers so angular passing info as form data (not request payload)
        })
            .then(function (response) {
                $scope.statusCode = response.status;
                $scope.data = response.data;
                if (response.status == 200) {
                    alert(successMsg);
                }
              //  alert(response.status);
            }, function (response) {
                $scope.statusCode = response.status;
                $scope.errorEmail = "ERROR!!!"
                if ((response.status == 405) || (response.status == 500) || (response.status == 401)) {
                    alert(errorMsg+". HTTP error code "+response.status);
                }
            });
    };

});

myApp.controller('signupController', function ($scope, $http) {
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

