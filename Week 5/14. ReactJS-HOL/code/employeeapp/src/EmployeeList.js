import React from 'react';
import EmployeeCard from './EmployeeCard';

function EmployeeList({ employees }) {
  return (
    <div className="employee-list">
      {employees.map((emp) => (
        <EmployeeCard key={emp.id} employee={emp} />
      ))}
    </div>
  );
}

export default EmployeeList;