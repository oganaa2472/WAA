
import './App.css'
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Dashboard from './Dashboard'
import HomePage from './pages/HomePage.tsx'
import Missing from './pages/Missing.tsx'
import { PostProvider } from './PostContext.tsx';
function App() {
  return (
    <>
    <PostProvider>
       {/* {<Dashboard />} */}
       <Router>
        <Routes>
          
          <Route path="/" element={<HomePage />} />
          <Route path="/home" element={<HomePage />} />
          {/* <Route path="/bookmark" element={<Bookmark />} /> */}
          {/* <Route path="/add-contact" element={<AddContact />} /> */}
          <Route path="*" element={<Missing />} />
        </Routes>
    </Router>
     
    </PostProvider>
    
    </>
  )
}

export default App
