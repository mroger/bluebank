'use strict';

 angular.module('config', [])
    .constant('ENV', 
        {
            name:'development',
            accountServiceURL:'http://localhost:8080'
        }
    );