import React, { Component } from "react";
import Cart from "./Cart";

class OnlineShopping extends Component {
  constructor(props) {
    super(props);

    this.items = [
      { itemName: "Laptop", price: 55000 },
      { itemName: "Smartphone", price: 25000 },
      { itemName: "Headphones", price: 3000 },
      { itemName: "Keyboard", price: 1500 },
      { itemName: "Mouse", price: 800 }
    ];
  }

  render() {
    return (
      <div style={{ textAlign: "center" }}>
        <h1>Online Shopping Cart</h1>

        <table
          border="1"
          cellPadding="10"
          style={{ margin: "auto", borderCollapse: "collapse" }}
        >
          <thead>
            <tr>
              <th>Item Name</th>
              <th>Price</th>
            </tr>
          </thead>

          <tbody>
            {this.items.map((item, index) => (
              <Cart key={index} item={item} />
            ))}
          </tbody>
        </table>
      </div>
    );
  }
}

export default OnlineShopping;