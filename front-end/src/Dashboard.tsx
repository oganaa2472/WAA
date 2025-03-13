
import React, { useEffect, useState } from 'react';
import PostList from './components/PostList.tsx'
import { usePosts,PostType } from './PostContext.tsx';
const PostDetails: React.FC<{ post: PostType | null }> = ({ post }) => {
    if (!post) return <p>Select a post to see details.</p>;
    return (
      <div className="border p-4 rounded-lg shadow-md">
        <h3 className="text-xl font-bold">{post.name}</h3>
        <p>{post.name}</p>
        <div className="mt-2">
          <button color="primary" className="mr-2">
            Edit
          </button>
          <button color="secondary">
            Delete
          </button>
        </div>
      </div>
    );
  };
const Dashboard = () => {   
  const { state } = usePosts();

    const [name,setName] = useState("");
    const [posts, setPosts] = useState<PostType[]>([
        // { id: 1, title: 'Post 1', author: "Ganaa", },
        // { id: 2, title: 'Post 2', author: "John", },
        // { id: 3, title: 'Post 3', author: "Doe",  },
    ]);
    const [post,setPost] = useState<PostType>()
    const deletePost = (id:number) =>{
        // setProducts((prev)=>(
        //     prev.map((product)=>
        //         product.id===productId?{...product,inStock:!product.inStock}:product
        //     ))
        // )
        
        const newList = posts.filter((item) => item.id !== id);

        setPosts(newList);
    };
    const updatePost = () => {
        if(post!=null)
        setPosts((prev)=>(
            prev.map((t)=>
                t.id===post.id?{...t,title:name}:t
            ))
        )
      };
    
    return (
      <div>
       <h1 className="text-2xl font-bold">Dashboard</h1>
        <div className="flex space-x-2">
            <input
            placeholder="Update first post title"
            value={name}
            onChange={(e) => setName(e.target.value)}
            />
            <button onClick={updatePost}>Update</button>
        </div>
        <ul>
            <PostList posts={state.posts} />
        </ul>
        {/* <div className="border p-4 rounded-lg shadow-md">
        <h3 className="text-xl font-bold">{post.title}</h3>
        <p>{post.title}</p>
        <div className="mt-2">
          <button color="primary" className="mr-2" >
            Edit
          </button>
          <button color="secondary" onClick={()=>deletePost(post.id)}>
            Delete
          </button>
        </div> */}
      {/* </div> */}
      </div>
    );
  }
  

  export default Dashboard;