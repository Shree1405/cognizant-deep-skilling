import React, { Component } from 'react';
import EmployeeList from './EmployeeList';
import ThemeContext from './ThemeContext';
import './App.css';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      theme: 'dark', // Toggle default theme ('dark' or 'light')
      employees: [
        { id: 1, name: 'John Doe', designation: 'Software Engineer' },
        { id: 2, name: 'Jane Smith', designation: 'UI/UX Designer' },
        { id: 3, name: 'Alex Johnson', designation: 'Project Manager' },
      ],
    };
  }

  toggleTheme = () => {
    this.setState((prevState) => ({
      theme: prevState.theme === 'dark' ? 'light' : 'dark',
    }));
  };

  render() {
    return (
      <ThemeContext.Provider value={this.state.theme}>
        <div className="App">
          <h1>Employee Management Application</h1>
          <button onClick={this.toggleTheme} style={{ marginBottom: '20px' }}>
            Switch to {this.state.theme === 'dark' ? 'Light' : 'Dark'} Theme
          </button>
          
          {/* Theme is NOT passed as props here */}
          <EmployeeList employees={this.state.employees} />
        </div>
      </ThemeContext.Provider>
    );
  }
}

export default App;