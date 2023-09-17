import axios from "axios";

const apiClient = axios.create({ baseURL: "http://localhost:8080" });

export const retrieveAllTodosByUsername = (username) => apiClient.get(`/users/${username}/todos`);
export const deleteATodoByIdAndUsername = (username, id) => apiClient.delete(`/users/${username}/todos/${id}`);
export const retrieveTodoByIdAndUsername = (username, id) => apiClient.get(`/users/${username}/todos/${id}`);
export const updateTodoByIdAndUsername = (username, todo, id) => apiClient.put(`/users/${username}/todos/${id}`, todo);
export const createTodo = (username, todo) => apiClient.post(`/users/${username}/todos`, todo);



