const { Add } = require('../math');
const { should, expect } = require('chai');
should();

describe('Addition Tests', () => {
    it('should return 3 when passed 1 and 2', () => {
        const numOne = 1;
        const numTwo = 2;

        const expected = 3;
        const actual = Add(numOne, numTwo);  

        actual.should.equal(expected); // 'should' style
        expect(actual).to.equal(expected); // 'expect' style

    });

    it('should not return 3 when passed 1 and 4', () => {
        const numOne = 1;
        const numTwo = 4;

        const expected = 3;
        const actual = Add(numOne, numTwo);  

        actual.should.not.equal(expected);
        expect(actual).to.not.equal(expected);
    })
});