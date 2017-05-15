'use strict';

/**
 * @ngdoc service
 * @name bluebankApp.accountService
 * @description
 * # accountService
 * Service in the bluebankApp.
 */
angular.module('bluebankApp')
  .service('accountService', ['$http', 'ENV', '$log', 'toastr', function ($http, ENV, $log, toastr) {

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
              toastr.success('Current balance: ' + response.data.balance, 'Transfer');
            },
            function(response) {
              $log.debug(response);
              console.log(response.data);
              toastr.error(response.data.message, 'Transfer');
            });
      }
    };

    return self;
  }]);
