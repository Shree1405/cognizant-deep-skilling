import axios from 'axios';
import GitClient from './GitClient';

// Mock the axios module
jest.mock('axios');

describe('Git Client Tests', () => {
  test('should return repository names for techiesyed', async () => {
    // 1. Define dummy mock data
    const dummyRepos = [
      { name: 'appscentricsolutions' },
      { name: 'ArrayListDemo' },
      { name: 'CleanArchitecture' }
    ];

    // 2. Configure mock implementation for axios.get
    axios.get.mockResolvedValue({ data: dummyRepos });

    // 3. Invoke getRepositories()
    const response = await GitClient.getRepositories('techiesyed');

    // 4. Assertions
    expect(response.data).toEqual(dummyRepos);
    expect(axios.get).toHaveBeenCalledWith('https://api.github.com/users/techiesyed/repos');
  });
});