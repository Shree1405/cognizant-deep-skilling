 /* @jest-environment jsdom */
import React from 'react';
import { mount, shallow } from 'enzyme';
import CohortDetails from './CohortDetails';
import { CohortData } from './Cohort';

describe('Cohort Details Component', () => {
  const sampleCohort = CohortData[0];

  // Test 1: should create the component
  test('should create the component', () => {
    const wrapper = shallow(<CohortDetails cohort={sampleCohort} />);
    expect(wrapper.exists()).toBeTruthy();
  });

  // Test 2: should initialize the props
  test('should initialize the props', () => {
    const wrapper = mount(<CohortDetails cohort={sampleCohort} />);
    expect(wrapper.props().cohort).toEqual(sampleCohort);
  });

  // Test 3: should display cohort code in h3
  test('should display cohort code in h3', () => {
    const wrapper = mount(<CohortDetails cohort={sampleCohort} />);
    const h3Element = wrapper.find('h3');
    expect(h3Element.text()).toContain(sampleCohort.cohortCode);
  });

  // Test 4: should always render same html
  test('should always render same html', () => {
    const wrapper = shallow(<CohortDetails cohort={sampleCohort} />);
    expect(wrapper).toMatchSnapshot();
  });
});