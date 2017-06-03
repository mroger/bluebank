//mongod
// cd E:\Software\MongoDB\Server\3.4\bin
// mongod --dbpath E:\Projects\Fullstack\bluebank\server-node\data

const mongoose = require('mongoose');
const config = require('../configuration')();
const Promise = require('bluebird').Promise;

const connectionString = config.get("mongo:url");
const options = { server: { auto_reconnect: true, poolSize: 10 } };

//mongoose.connection.open(connectionString, options);
const db = mongoose.connect(connectionString, options);
db.Promise = Promise;

//TODO
/*
. Log dos eventos do mongoose: http://theholmesoffice.com/mongoose-connection-best-practice/
. Em caso de erro de conexão, registrar estado para notificar subscribers
. Criar stream RxJs para notificar subscribers sobre o estado da aplicação

. Exemplo:

var db = mongoose.connection;
var connected;
db.on('open', function (ref) {
    connected = true;
    console.log('open connection to mongo server.');
});

db.on('connected', function (ref) {
    global.mongo_conn=true;
    console.log('Connected connection to mongo server.');
});

db.on('disconnected', function (ref) {
    connected = false;
    console.log('disconnected connection.');
});
db.on('disconnect', function (err) {
    console.log('Error...disconnect', err);
});
db.on('connecting', function (ref) {
    connected = false;
    console.log('connecting.');
});

db.on('close', function (ref) {
    global.mongo_conn=false;
    console.log('close connection.');
    connect();
});

db.on('error', function (ref) {
    connected = false;
    console.log('Error connection.');
    //mongoose.disconnect();
    global.mongo_conn=false;
});

db.on('reconnected', function () {
    global.mongo_conn=true;
    console.log('MongoDB reconnected!');
});
db.on('reconnecting', function () {
    global.mongo_conn=true;
    console.log('reconnecting!');
});
function connect() {
    mongoose.connect(config.mongo.uri, opts);
}

connect();
*/