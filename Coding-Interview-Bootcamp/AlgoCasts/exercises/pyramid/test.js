const { pyramid } = require('./index');

describe('pyramid', () => {
  beforeEach(() => {
    jest.spyOn(console, 'log')
  })
  
  afterEach(() => {
    console.log.mockRestore()
  })
  
  it('should log a single hash for n = 1', () => {  
    pyramid(1)
    expect(console.log).toHaveBeenCalledTimes(1)
    expect(console.log).toHaveBeenNthCalledWith(1, '#')
  });
  
  it('should log a 2 level pyramid for n = 2', () => {  
    pyramid(2)
    expect(console.log).toHaveBeenCalledTimes(2)
    expect(console.log).toHaveBeenNthCalledWith(1, ' # ')
    expect(console.log).toHaveBeenNthCalledWith(2, '###')
  });

  it('should log a 3 level pyramid for n = 3', () => {  
    pyramid(3)
    expect(console.log).toHaveBeenCalledTimes(3)
    expect(console.log).toHaveBeenNthCalledWith(1, '  #  ')
    expect(console.log).toHaveBeenNthCalledWith(2, ' ### ')
    expect(console.log).toHaveBeenNthCalledWith(3, '#####')
  });

  it('should log a 4 level pyramid for n = 4', () => {  
    pyramid(4)
    expect(console.log).toHaveBeenCalledTimes(4)
    expect(console.log).toHaveBeenNthCalledWith(1, '   #   ')
    expect(console.log).toHaveBeenNthCalledWith(2, '  ###  ')
    expect(console.log).toHaveBeenNthCalledWith(3, ' ##### ')
    expect(console.log).toHaveBeenNthCalledWith(4, '#######')
  });
});
