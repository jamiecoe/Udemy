import React, { Component } from 'react';
import { connect } from 'react-redux';
import { deposit, withdraw } from '../actions/balance';

// In order to test the unconnected 'Wallet' component, we also export the component class,
// As well as 'export default' at the bottom for the Redux connected component
export class Wallet extends Component {
  constructor() {
    super();
    this.state = {
      balance: undefined
    };
  }

  updateBalance = (e) => {
    const balance = parseInt(e.target.value);
    this.setState({ balance });
  }

  deposit = () => {
    this.props.deposit(this.state.balance); 
  }

  withdraw = () => {
    this.props.withdraw(this.state.balance); 
  }

  render() {
    return (
      <div>
        <h3 className='balance'>Wallet balance: {this.props.balance}</h3>
        <br />
        <input className='input-wallet' onChange={this.updateBalance} />
        <button className='btn-deposit' onClick={this.deposit}>Deposit</button>
        <button className='btn-withdraw' onClick={this.withdraw}>Withdraw</button>
      </div>
    )
  }
}

const mapStateToProps = state => ({
  balance: state.balance
});

export default connect(mapStateToProps, { deposit, withdraw })(Wallet);