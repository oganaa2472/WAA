import React, { createContext, useReducer, useContext, useEffect, ReactNode } from 'react';
const API_URL = 'http://localhost:8080/api/posts';
export interface PostType{
    id: number;
    name: string;
    author: string;
    content:string;
}
interface PostState {
posts: PostType[];
loading: boolean;
post:PostType|null;
}
type PostAction =
    | {type: 'SET_POST',post:PostType}
  | { type: 'SET_CONTACTS'; posts: PostType[] }
  | { type: 'ADD_CONTACT'; post: PostType }
  | { type: 'REMOVE_CONTACT'; id: number }
  | { type: 'UPDATE_CONTACT'; post: PostType }
  | { type: 'SET_LOADING'; loading: boolean };
const postReducer = (state: PostState,action:PostAction):PostState=>{
    switch(action.type){
        case 'SET_CONTACTS':
            return {...state,posts:action.posts,loading:false};
        case 'ADD_CONTACT':
            return {...state,posts:[...state.posts,action.post]};
        case 'REMOVE_CONTACT':
            return {...state,posts:state.posts.filter(c=>c.id!==action.id)};
        case 'UPDATE_CONTACT':
            return {...state,posts:state.posts.map(
                p => p.id===action.post.id?action.post:p
            )};
        case 'SET_POST':
            return {...state, post: action.post}
        case 'SET_LOADING':
            return { ...state, loading: action.loading };
        default: return state;
    }
}
interface PostContextType{
    state:PostState,
    dispatch:React.Dispatch<PostAction>
};
const PostContext = createContext<PostContextType | undefined>(undefined);
interface PostProviderProps {
    children: ReactNode;
  }
  
export const PostProvider : React.FC<PostProviderProps> = ({children})=>{
    const [state, dispatch] = useReducer(postReducer, { posts: [],post:null,  loading: true,});
    useEffect(()=>{
        const fetchPost = async()=>{
            dispatch({ type: 'SET_LOADING', loading: true });
            try{
                const response = await fetch(API_URL);
                const rejson = await response.json();
                const data: PostType[] = rejson;
                dispatch({ type: 'SET_CONTACTS', posts: data });
            }catch(error){
                console.error('Error fetching contacts:', error);
            }
        }
        fetchPost();
    },[])
   
    return (
        <PostContext.Provider value={{state,dispatch}}>
            {children}
        </PostContext.Provider>
    )
}
export const usePosts= (): PostContextType=>{
    const context = useContext(PostContext);
    if (!context) {
        throw new Error('useContacts must be used within a ContactProvider');
      }
      return context;
}