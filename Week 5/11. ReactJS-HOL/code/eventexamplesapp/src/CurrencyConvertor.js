import React, { Component } from "react";

class CurrencyConvertor extends Component {
  constructor() {
    super();

    this.state = {
      amount: "",
      currency: "Euro",
    };
  }

  handleAmount = (event) => {
    this.setState({
      amount: event.target.value,
    });
  };

  handleSubmit = (event) => {
    event.preventDefault();

    const result = this.state.amount * 80;

    alert("Converting to Euro Amount is " + result);
  };

  render() {
    return (
      <div>

        <h1 style={{ color: "green" }}>
          Currency Convertor!!!
        </h1>

        <form onSubmit={this.handleSubmit}>

          <label>Amount:&nbsp;</label>

          <input
            type="number"
            value={this.state.amount}
            onChange={this.handleAmount}
          />

          <br />
          <br />

          <label>Currency:&nbsp;</label>

          <input
            type="text"
            value={this.state.currency}
            readOnly
          />

          <br />
          <br />

          <button type="submit">
            Submit
          </button>

        </form>

      </div>
    );
  }
}

export default CurrencyConvertor;