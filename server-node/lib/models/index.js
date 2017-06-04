const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const AccountSchema = new Schema({
    number : { type: Number, required: true }
    , agency : { type: Number, required: true }
    , balance : { type: Number, required: true }
});
AccountSchema.index({number: 1, agency: 1}, {unique: true});

mongoose.model('Account', AccountSchema);

module.exports = mongoose;