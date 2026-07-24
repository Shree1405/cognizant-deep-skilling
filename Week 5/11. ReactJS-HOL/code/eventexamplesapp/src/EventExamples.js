import React, { Component } from "react";

class EventExamples extends Component {
  constructor() {
    super();

    this.state = {
      count: 0,
    };
  }

  increment = () => {
    this.setState({
      count: this.state.count + 1,
    });
  };

  decrement = () => {
    this.setState({
      count: this.state.count - 1,
    });
  };

  sayHello = () => {
    alert("Hello! Member1");
  };

  incrementValue = () => {
    this.increment();
    this.sayHello();
  };

  sayWelcome = (msg) => {
    alert(msg);
  };

  onPress = () => {
    alert("I was clicked");
  };

  render() {
    return (
      <div>
        <h3>{this.state.count}</h3>

        <button onClick={this.incrementValue}>Increment</button>
        <br />

        <button onClick={this.decrement}>Decrement</button>
        <br />

        <button onClick={() => this.sayWelcome("Welcome")}>
          Say welcome
        </button>
        <br />

        <button onClick={this.onPress}>Click on me</button>
      </div>
    );
  }
}

export default EventExamples;