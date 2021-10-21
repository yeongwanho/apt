// 학습 노트 조작과 관련된 CRUD API 함수 파일
import { posts } from './index';

// 학습 노트 데이터 목록을 조회하는 API
function fetchPosts(page) {
  console.log(page);
  return posts.get('', {
    params: {
      page: page,
      size: 20,
    },
  });
}
function fetchDetailApt(commentData) {
  return posts.post('comment', commentData);
}

function fetchAPT(aptData) {
  return posts.get('', {
    params: {
      page: aptData.page,
      size: 20,
      cityL: aptData.cityL,
      cityM: aptData.cityM,
      cityS: aptData.cityS,
    },
  });
}

// 특정 학습 노트를 조회하는 API
function fetchPost(aptData) {
  return posts.get('detail', {
    params: {
      id: aptData.id,
      aptName: aptData.aptName,
    },
  });
}

// 학습 노트 데이터를 생성하는 API
function createPost(postData) {
  return posts.post('comment', postData);
}

// 학습 노트 데이터를 삭제하는 API
function deletePost(postId) {
  return posts.delete(postId);
}

// 학습 노트 데이터를 수정하는 API
function editPost(postId, postData) {
  return posts.put(postId, postData);
}

export {
  fetchPosts,
  fetchPost,
  createPost,
  deletePost,
  editPost,
  fetchAPT,
  fetchDetailApt,
};
