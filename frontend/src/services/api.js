import axios from 'axios';

const api = axios.create({
  baseURL: 'https://jsonplaceholder.typicode.com',
  timeout: 8000,
});

export const fetchDashboardData = async () => {
  const [profileResponse, postsResponse] = await Promise.all([
    api.get('/users/1'),
    api.get('/posts/1'),
  ]);

  return {
    profile: profileResponse.data,
    insight: postsResponse.data,
  };
};
