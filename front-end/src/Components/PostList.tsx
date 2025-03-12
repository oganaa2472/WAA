

import './PostList.css'
import { Post as PostType} from '../PostContext.tsx';
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