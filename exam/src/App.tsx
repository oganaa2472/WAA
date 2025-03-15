import React, { useState, useEffect, ChangeEvent, FormEvent } from 'react';
import { BrowserRouter as Router, Route, Routes, Link, useParams, useNavigate, useLocation } from 'react-router-dom';
const API_BASE = "https://65bd8dd8b51f9b29e9338ba8.mockapi.io/api/v1/libraries";


interface Library {
  id: string;
  name: string;
  city: string;
}

interface Book {
  id: string;
  title: string;
  author: string;
  quantity: number;
}

const Library = ({ library }: { library: Library }) => (
  <div>
    <h3>{library.name} - {library.city}</h3>
    <Link to={`/${library.id}/books`} state={library}>View Books</Link>
  </div>
);

const Libraries = () => {
  const [libraries, setLibraries] = useState<Library[]>([]);

  useEffect(() => {
    fetch(API_BASE)
      .then((res) => res.json())
      .then(setLibraries);
  }, []);

  return (
    <div>
      <h2>Libraries</h2>
      {libraries.map((lib) => <Library key={lib.id} library={lib} />)}
    </div>
  );
};

const Book = ({ book }: { book: Book }) => (
  <div>
    <h4>{book.title} by {book.author} (Quantity: {book.quantity})</h4>
  </div>
);

const Books = () => {
  const { libraryId } = useParams<{ libraryId: string }>();
  const { state: library } = useLocation<Library>();
  const [books, setBooks] = useState<Book[]>([]);
  const navigate = useNavigate();

  useEffect(() => {
    fetch(`${API_BASE}/${libraryId}/books`)
      .then((res) => res.json())
      .then(setBooks);
  }, [libraryId]);

  return (
    <div>
      <h2>{library?.name}'s Books</h2>
      {books.map((book) => <Book key={book.id} book={book} />)}
      <button onClick={() => navigate(`/${libraryId}/add-book`, { state: library })}>Add Book</button>
      <button onClick={() => navigate("/")}>Back</button>
    </div>
  );
};

const AddBook = () => {
  const { libraryId } = useParams<{ libraryId: string }>();
  const { state: library } = useLocation<Library>();
  const navigate = useNavigate();
  const [formData, setFormData] = useState<{ title: string; author: string; quantity: string }>({
    title: '',
    author: '',
    quantity: ''
  });

  const handleChange = (e: ChangeEvent<HTMLInputElement>) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e: FormEvent) => {
    e.preventDefault();
    await fetch(`${API_BASE}/${libraryId}/books`, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ ...formData, libraryId, quantity: Number(formData.quantity) })
    });
    navigate(`/${libraryId}/books`, { state: library });
  };

  return (
    <div>
      <h2>Add Book to {library?.name}</h2>
      <form onSubmit={handleSubmit}>
        <input name="title" placeholder="Title" value={formData.title} onChange={handleChange} required />
        <input name="author" placeholder="Author" value={formData.author} onChange={handleChange} required />
        <input name="quantity" type="number" placeholder="Quantity" value={formData.quantity} onChange={handleChange} required />
        <button type="submit">Add Book</button>
      </form>
    </div>
  );
};

const App = () => (
  <Router>
    <Routes>
      <Route path="/" element={<Libraries />} />
      <Route path=":libraryId/books" element={<Books />} />
      <Route path=":libraryId/add-book" element={<AddBook />} />
    </Routes>
  </Router>
);

export default App;
