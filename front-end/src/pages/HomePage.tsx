import { useState } from "react";
import { NavLink } from "react-router-dom"; // Import Link for navigation
import { Menu, X, Home, Contact, Star } from "lucide-react";
import Dashboard from "./Dashboard";
// import TableView from "../TableView.tsx";
interface NavItemProps {
  to: string;
  icon: JSX.Element;
  text: string;
}

const HomePage = () => {
//   const [isMenuOpen, setIsMenuOpen] = useState(false);
  return (
    <div >
      {/* Header */}
      <header className="bg-white shadow p-4 flex justify-between items-center">
        <h1 className="text-xl font-semibold">
          <Contact size={24} className="inline mb-2 mr-4" /> Post
        </h1>
        {/* Navigation Links (Desktop) */}
        <nav className="hidden md:flex space-x-6">
          <NavItem to="/" icon={<Home size={20} />} text="Dashboard" />
          <NavItem to="/add-post" icon={<Star size={20} />} text="AddPost" />
        </nav>
      </header>

     {/* <Dashboard /> */}
   

      {/* Table View Component */}
    
       
        
     
    </div>
    
  );
};

// Navbar Item Component (Uses Link)
const NavItem = ({ to, icon, text }: NavItemProps) => (
  <NavLink
    to={to}
    className={({ isActive }) =>
      `flex items-center space-x-2 p-2 rounded-lg cursor-pointer hover:bg-gray-200 ${
        isActive ? "rounded-md bg-indigo-600 px-3.5 py-2.5 text-sm font-semibold text-white shadow-xs hover:bg-indigo-500 focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600" : "text-gray-700"
      }`
    }
  >
    {/* {icon} */}
    <span className="text-lg">{text}</span>
  </NavLink>
);

export default HomePage;