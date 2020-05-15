const vowels = require('./index');

describe('vowels', () => {
  it('should return 0 if the input string is empty', () => {
    expect(vowels('')).toEqual(0)
  });

  it('should return 0 if there are no vowels in the input string', () => {
    expect(vowels('ctr')).toEqual(0)
  });

  describe('single vowels', () => {
    it('should return 1 if there is one `a` inside the string ', () => {
      expect(vowels('ast')).toEqual(1)
    });
  
    it('should return 1 if there is one `e` inside the string ', () => {
      expect(vowels('est')).toEqual(1)
    });
  
    it('should return 1 if there is one `i` inside the string ', () => {
      expect(vowels('ist')).toEqual(1)
    });
  
    it('should return 1 if there is one `o` inside the string ', () => {
      expect(vowels('ost')).toEqual(1)
    });
  
    it('should return 1 if there is one `u` inside the string ', () => {
      expect(vowels('ust')).toEqual(1)
    });
  });

  describe('multiple vowels', () => {
    it('should count the number of the vowels, if the vowels are the same', () => {
      expect(vowels('aaabg')).toEqual(3)
    });

    it('should count the number of the vowels, if the vowels are different', () => {
      expect(vowels('aeioufg')).toEqual(5)
    });
  });

  describe('CAPITAL vowels', () => {
    it('should count the number of vowels, if the letters are uppercase', () => {
      expect(vowels('AEIGHN')).toEqual(3)
    });
  });

  describe('full sentences', () => {
    it('should count the number of vowels, if the letters are uppercase', () => {
      expect(vowels('The cat lived in London.')).toEqual(7)
    });
  })

});











// test('Vowels is a function', () => {
//   expect(typeof vowels).toEqual('function');
// });

// test('returns the number of vowels used', () => {
//   expect(vowels('aeiou')).toEqual(5);
// });

// test('returns the number of vowels used when they are capitalized', () => {
//   expect(vowels('AEIOU')).toEqual(5);
// });

// test('returns the number of vowels used', () => {
//   expect(vowels('abcdefghijklmnopqrstuvwxyz')).toEqual(5);
// });

// test('returns the number of vowels used', () => {
//   expect(vowels('bcdfghjkl')).toEqual(0);
// });
