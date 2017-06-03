const mongoose = require('mongoose');
const Schema = mongoose.Schema;

let AccountSchema = new Schema({
    number : { type: Number, required: true }
    , agency : { type: Number, required: true }
    , balance : { type: Number, required: true }
});

mongoose.model('Account', AccountSchema);

module.exports = mongoose;