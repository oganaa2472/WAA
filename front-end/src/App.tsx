
import './App.css'
import Dashboard from './Dashboard'
import { PostProvider } from './PostContext.tsx';
function App() {
  return (
    <>
    <h1>Assigment 6</h1>
    <PostProvider>
       <Dashboard>
    
        </Dashboard>
    </PostProvider>
    
    </>
  )
}

export default App
