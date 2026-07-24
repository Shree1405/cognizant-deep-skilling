import React, { Component } from 'react';

class ComplaintRegister extends Component {
  constructor(props) {
    super(props);
    this.state = {
      ename: '',
      complaint: '',
      NumberHolder: Math.floor(Math.random() * 100) + 1, // Random Transaction ID
    };
  }

  // Dynamic state handler using event.target.name (From Hint Image 1)
  handleChange = (event) => {
    this.setState({ [event.target.name]: event.target.value });
  };

  // Submit handler (From Hint Image 2)
  handleSubmit = (event) => {
    var msg =
      'Thanks ' +
      this.state.ename +
      '. \nYour Complaint was Submitted. \nTransaction ID is: ' +
      this.state.NumberHolder;
    alert(msg);
    event.preventDefault();
  };

  render() {
    return (
      <div style={{ textAlign: 'center', marginTop: '50px' }}>
        <h1 style={{ color: 'red' }}>Register your complaints here!!!</h1>
        
        <form onSubmit={this.handleSubmit} style={{ display: 'inline-block' }}>
          <table style={{ margin: '0 auto', textAlign: 'left' }}>
            <tbody>
              <tr>
                <td style={{ padding: '10px', fontWeight: 'bold' }}>Name:</td>
                <td style={{ padding: '10px' }}>
                  <input
                    type="text"
                    name="ename"
                    value={this.state.ename}
                    onChange={this.handleChange}
                    style={{ width: '200px' }}
                  />
                </td>
              </tr>
              <tr>
                <td style={{ padding: '10px', fontWeight: 'bold', verticalAlign: 'top' }}>
                  Complaint:
                </td>
                <td style={{ padding: '10px' }}>
                  <textarea
                    name="complaint"
                    value={this.state.complaint}
                    onChange={this.handleChange}
                    rows="3"
                    style={{ width: '200px' }}
                  />
                </td>
              </tr>
              <tr>
                <td colSpan="2" style={{ textAlign: 'center', paddingTop: '10px' }}>
                  <button type="submit" style={{ padding: '4px 12px' }}>
                    Submit
                  </button>
                </td>
              </tr>
            </tbody>
          </table>
        </form>
      </div>
    );
  }
}

export default ComplaintRegister;