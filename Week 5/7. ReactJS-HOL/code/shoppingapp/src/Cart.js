import React, { Component } from "react";

class Cart extends Component {
  render() {
    return (
      <tr>
        <td>{this.props.item.itemName}</td>
        <td>₹ {this.props.item.price}</td>
      </tr>
    );
  }
}

export default Cart;