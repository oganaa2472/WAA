

import './PostList.css'
import { PostType} from '../PostContext.tsx';
import Post from './Post.tsx';


const PostList: React.FC<{ posts: PostType[]}> = ({ posts }) => {
    return (
      <div>
        <ul className='post-container'>
            {
                posts.map((post)=>(
                    <Post key={post.id} post={post} />

                ))
            }
        </ul>
      </div>
    );
  }
  

  export default PostList;