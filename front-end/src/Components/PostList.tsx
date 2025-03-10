
import React, { useEffect, useState } from 'react';
import {PostType} from '../types.tsx'
import './PostList.css'
import Post from './Post.tsx'
const PostList: React.FC<{ posts: PostType[]; onSelect: (post: PostType) => void }> = ({ posts, onSelect }) => {
    return (
      <div>
        <ul className='post-container'>
            {
                posts.map((post)=>(
                    <Post key={post.id} post={post} onSelect={onSelect} />

                ))
            }
        </ul>
      </div>
    );
  }
  

  export default PostList;