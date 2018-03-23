const Add = (num1, num2, log) => {
    const result = num1 + num2;
    log(result);
    return result;
};

const isAlive = (ping) => {
  const pingOneSucess = ping();
  const pingTwoSuccess = ping();
  const pingThreeSuccess = ping();

  return pingOneSucess && pingTwoSuccess && pingThreeSuccess;
}


const isAliveError = (ping) => {
  try {
    const pingOneSucess = ping();
    const pingTwoSuccess = ping();
    const pingThreeSuccess = ping();
  } catch (e) {
    return new Error('ping threw exception');
  }

  return pingOneSucess && pingTwoSuccess && pingThreeSuccess;
}


module.exports = { Add, isAlive, isAliveError };
