import './App.css';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Dashboard from './pages/Dashboard.tsx';
import HomePage from './pages/HomePage.tsx';
import AddPost from './pages/AddPost.tsx';
// Your navbar
import Missing from './pages/Missing.tsx';
import { PostProvider } from './PostContext.tsx';

function App() {
  return (
    <PostProvider>
      <Router>
        <HomePage /> Navbar stays visible on all routes
        <Routes>
          <Route path="/" element={<Dashboard />} /> {/* Root route to Dashboard */}
          <Route path="/home" element={<Dashboard />} /> {/* /home also renders Dashboard */}
          <Route path="/add-post" element={<AddPost />} /> 
          <Route path="*" element={<Missing />} /> {/* Catch-all route for 404 */}
        </Routes>
      </Router>
    </PostProvider>
  );
}

export default App;
