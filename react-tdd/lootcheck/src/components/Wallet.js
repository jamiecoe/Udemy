import React, { Component } from 'react';
import { connect } from 'react-redux';

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

  render() {
    return (
      <div>
        <h3 className='balance'>Wallet balance: {this.props.balance}</h3>
        <br />
        <input className='input-wallet' onChange={this.updateBalance} />
      </div>
    )
  }
}

const mapStateToProps = state => ({
  balance: state
});

export default connect(mapStateToProps, null)(Wallet);