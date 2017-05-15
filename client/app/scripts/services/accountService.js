'use strict';

/**
 * @ngdoc service
 * @name bluebankApp.accountService
 * @description
 * # accountService
 * Service in the bluebankApp.
 */
angular.module('bluebankApp')
  .service('accountService', ['$http', 'ENV', function ($http, ENV) {

    var self = {
      'transfer': function() {
        
        var request = {
          accountNumberFrom: 1,
          accountAgencyFrom: 1,
          accountNumberTo: 2,
          accountAgencyTo: 1,
          amount: 10.0,
          description: 'Transfer number one'
        };

        $http
          .post(ENV.accountServiceURL + '/accounts/transfer', request)
          .then(
            function(response) {
              console.log(response);
            },
            function(response) {
              console.log(response);
            });
      }
    };

    return self;
  }]);
