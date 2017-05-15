'use strict';

/**
 * @ngdoc function
 * @name bluebankApp.controller:AccountCtrl
 * @description
 * # AccountCtrl
 * Controller of the bluebankApp
 */
angular.module('bluebankApp')
  .controller('AccountCtrl', ['$scope', 'accountService', function ($scope, accountService) {
    var ctrl = this;

    ctrl.transfer = function(transferData) {
      console.log(transferData);
      console.log('controller...');
      accountService.transfer(transferData);
    };

  }]);
