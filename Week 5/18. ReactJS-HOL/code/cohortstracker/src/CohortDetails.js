import React from 'react';

function CohortDetails({ cohort }) {
  if (!cohort) return null;

  return (
    <div className="cohort-details">
      <h3>{cohort.cohortCode}</h3>
      <p>Technology: {cohort.technology}</p>
      <p>Start Date: {cohort.startDate}</p>
      <p>Current Stage: {cohort.currentStage}</p>
    </div>
  );
}

export default CohortDetails;