import './App.css';
import { useState, useEffect } from 'react';
import api from './api/axiosConfig';
import Layout from './components/Layout';
import {Routes, Route} from 'react-router-dom';
import Home from './components/home/Home';
import Header from './components/header/Header';

function App() {

  const [movies, setMovies] = useState([]);

  const getMoviesFromAPI = async () => {

    // const baseUrl = `http://localhost:8080/`

    try {
      
      const response = await api.get(`/api/v1/movies`);

      console.log(response.data);
      
      setMovies(response.data);
    } catch (error) {
      console.log(error);
    }

  }

  useEffect(() => {
    getMoviesFromAPI()
  }, [])

  return (
    <div className="App">
      <Header/>
      <Routes>
        <Route path="/" element={<Layout />} >
          <Route path="/" element={<Home movies = {movies}/>} ></Route>

        </Route>
      </Routes>
    </div>
  );
}

export default App;
