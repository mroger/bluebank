'use strict';

/**
 * @ngdoc service
 * @name bluebankApp.accountService
 * @description
 * # accountService
 * Service in the bluebankApp.
 */
angular.module('bluebankApp')
  .service('accountService', ['$http', 'ENV', '$log', function ($http, ENV, $log) {

    var self = {
      'transfer': function(transferData) {
        
        var request = {
          accountNumberFrom: transferData.accountFrom,
          accountAgencyFrom: transferData.agencyFrom,
          accountNumberTo: transferData.accountTo,
          accountAgencyTo: transferData.agencyTo,
          amount: transferData.amount,
          description: transferData.description
        };

        $http
          .post(ENV.accountServiceURL + '/accounts/transfer', request)
          .then(
            function(response) {
              $log.debug(response);
            },
            function(response) {
              $log.debug(response);
            });
      }
    };

    return self;
  }]);
