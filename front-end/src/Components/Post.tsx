import React from 'react';


import './Post.css'
import { PostType} from '../PostContext.tsx';
const Post: React.FC<{ post: PostType;}> = ({ post }) => {

    function onSelect(post:PostType){
      
    }
   return (
    <div className="border p-4 rounded-lg shadow-md cursor-pointer" 
    onClick={()=>onSelect(post)}
    >
      <h4 className='text-xl font-bold'>{post.author}</h4>
      <p className="text-xl font-bold">{post.content}</p>
      <p>{post.content}</p>
      
    </div>
  );
}

export default Post;
