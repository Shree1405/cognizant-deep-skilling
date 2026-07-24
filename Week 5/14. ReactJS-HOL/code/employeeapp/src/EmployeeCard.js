import React, { useContext } from 'react';
import ThemeContext from './ThemeContext';

function EmployeeCard({ employee }) {
  // Retrieve the context value directly
  const theme = useContext(ThemeContext);

  return (
    <div className="employee-card">
      <h3>{employee.name}</h3>
      <p>{employee.designation}</p>
      {/* Dynamic button styling based on context theme */}
      <button className={`btn ${theme}`}>
        View Details ({theme} mode)
      </button>
    </div>
  );
}

export default EmployeeCard;