import React, { Component } from "react";
import { connect } from "react-redux";
import { fetchBitcoin } from "../actions/bitcoin";

export class Loot extends Component {
  componentDidMount() {
    this.props.fetchBitcoin();
  }

  computeBitcoin = () => {
    const { balance, bitcoin } = this.props;

    if (Object.keys(bitcoin).length === 0) return '';

    return balance / parseInt(bitcoin.bpi.USD.rate.replace(',', ''));
  }

  render() {
    return <h3>Bitcoin balance: {this.computeBitcoin()}</h3>; 
  }
}

const mapStateToProps = state => state;

export default connect(mapStateToProps, { fetchBitcoin })(Loot);
