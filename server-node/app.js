// cd E:\Projects\Fullstack\bluebank\server-node
// gulp serve

'use strict';

const app = require('express')();
//Parse incoming request bodies in a middleware before your handlers, available under the req.body property
const bodyParser = require('body-parser');
const config = require('./lib/configuration/index')();
const db = require('./lib/db');
//Another log option
//var morgan = require('morgan');

const transactionRouter = require('./src/routes/transactionRoutes')();
const heartbeatRouter = require('./src/routes/heartbeatRoutes')();
const accountRouter = require('./src/routes/accountRoutes')();
const notFound = require('./src/middleware/notFound');

//Choose between parsing the URL-encoded data with the qs library
app.use(bodyParser.urlencoded({ extended: true }));
//Returns middleware that only parses json
app.use(bodyParser.json());
//To use this, uncomment require morgan
//app.use(morgan('combined'))

app.use(function(req, res, next) {
  res.setHeader('Access-Control-Allow-Origin', 'http://localhost:9000');
  res.setHeader('Access-Control-Allow-Methods', 'GET, POST, OPTIONS');
  res.setHeader('Access-Control-Allow-Headers', 'X-Requested-With, content-type, Authorization, X-UA-Compatible, X-XSS-Protection');
  next();
});

app.use('/accounts/transfer', transactionRouter);
app.use('/heartbeat', heartbeatRouter);
app.use('/accounts', accountRouter);
app.use(notFound.index);

app.listen(config.get('express:port'), function (err) {
    console.log('Listening to port ' + config.get('express:port'));
});

module.exports = app;