const { Add, isAlive, isAliveError, API } = require('../functions');
const { should, expect, assert } = require('chai');
const sinon = require('sinon');
should();

// describe('Addition Tests', () => {
//     it('should return 3 when passed 1 and 2', () => {
//         const numOne = 1;
//         const numTwo = 2;
//
//         const expected = 3;
//         const actual = Add(numOne, numTwo);
//
//         actual.should.equal(expected); // 'should' style
//         expect(actual).to.equal(expected); // 'expect' style
//         assert.equal(actual, expected, 'this test should pass') // 'assert' style
//
//     });
//
//     it('should not return 3 when passed 1 and 4', () => {
//         const numOne = 1;
//         const numTwo = 4;
//
//         const expected = 3;
//         const actual = Add(numOne, numTwo);
//
//         actual.should.not.equal(expected);
//         expect(actual).to.not.equal(expected);
//         assert.notEqual(actual, expected, 'this test should pass')
//     })
// });

describe('Spy Tests', () => {
  it('should log result of add', () => {
    const numOne = 1;
    const numTwo = 2;

    // sinon spies although us to check if a function has been called with the correct values
    const logSpy = sinon.spy();
    Add(numOne, numTwo, logSpy);

    // checking that logSpy() was actually called
    logSpy.called.should.be.true;
  });

  it('should call log with the correct result of add', () => {
    const numOne = 1;
    const numTwo = 2;

    // sinon spies although us to check if a function has been called with the correct values
    const logSpy = sinon.spy();
    Add(numOne, numTwo, logSpy);

    // checking that logSpy() was called with the correct result of add
    logSpy.calledWith(3).should.be.true;
  });
});

describe('isAlive tests', () => {
  it('should return true when ping callback returns true', () => {

    // Stubs are just like Spies, but with some extra behaviour
    // You can force stubs to behave in a particular way (unlike spies)
    // Eg: you can make stubs return a specific value based on some input arguements or the time when the function was called
    const pinger = sinon.stub();
    // pinger should return true whenever it's called
    pinger.returns(true);

    const isWebsiteAlive = isAlive(pinger);
    isWebsiteAlive.should.be.true;
  });

  it('should return true when ping returns true three times in a row', () => {

    const pinger = sinon.stub();

    // specify what pinger should return on each call
    pinger.onFirstCall().returns(true);
    pinger.onSecondCall().returns(true);
    pinger.onThirdCall().returns(true);

    const isWebsiteAlive = isAlive(pinger);
    isWebsiteAlive.should.be.true;
  });

  it('should return false when ping does not returns true three times in a row', () => {

    const pinger = sinon.stub();

    // specify what pinger should return on each call
    pinger.onFirstCall().returns(true);
    pinger.onSecondCall().returns(false);
    pinger.onThirdCall().returns(true);

    const isWebsiteAlive = isAlive(pinger);
    isWebsiteAlive.should.be.false;
  });

  it('should return an error when ping throws an error', () => {

    const pinger = sinon.stub();

    // specify what pinger should return on each call
    pinger.throws(() => new Error());
    const error = isAliveError(pinger);

    error.message.should.equal('ping threw exception');
  });


});

// Mocks are fake methods (like spies) and pre-programmed behaviour (like
// stubs), BUT they can also have pre-programmed expectations as well. The whole
// idea of a mock is that it will fail your tests if it isn't used as you would
// expect it to be This makes it really useful for mocking out a particular
// funciton within an object - we can place just that function under test and
// check it's used exactly how we expect it to be
describe('API tests', () => {
  it('should call ping 3 times with isAlive function', () => {
    // create a mocked version of API, which we can use to set expectations
    const mockAPI = sinon.mock(API);
    // inside expects(), pass in the name (as a string) of the function you want to set expectations for
    const mockPing = mockAPI.expects('ping');

    // we expect ping to be called exactly 3 times
    mockPing.exactly(3);
    // we expect ping to be called at least once and at most thrice 
    mockPing.atLeast(1).atMost(3);

    // you then call the isAlive function on the REAL API object
    // the ping function will still be mocked out
    API.isAlive();

    // with mocks, you need to call a 'verify' method, which will check your assertions
    mockAPI.verify();

    // you need to call 'restore' function to restore the real 'ping' function
    // as opposed to the mocked one 
    mockAPI.restore();
  })
})