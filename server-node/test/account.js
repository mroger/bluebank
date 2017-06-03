const app = require('../app');
const mongoose = require('mongoose');

beforeEach((done) => {
    mongoose.connection.collections['accounts']
    .drop((err) => {
        let account = {
            number: 1,
            agency: 1,
            balance: 100.0,
            creationDate: new Date('2017-05-23T22:28:00')
        };

        mongoose.connection.collections['accounts']
        .insert(account, (err, docs) => {
            id = docs[0]._id;
            done();
        });
    });
})

describe('when creating a new resource /accounts', () => {
    let account = {
        number: 1,
        agency: 1,
        balance: 100.0,
        creationDate: new Date('2017-05-23T22:28:00')
    };

    it('should respond with 201', (done) => {
        request(app)
        .post('/accounts')
        .send(account)
        .expect('Content-Type', /json/)
        .expect(201)
        .end((err, res) => {
            let _account = JSON.parse(res.text);
            assert.equal(_account.number, 1);
            assert.equal(_account.agency, 1);
            assert.equal(_account.balance, 100.0);
            assert.equal(_account.creationDate, new Date('2017-05-23T22:28:00'));
            done();
        });
    });
});