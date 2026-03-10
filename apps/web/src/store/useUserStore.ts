import {create} from 'zustand';

interface UserState {
    isLoggedIn: boolean;                // 로그인 여부
    userName: string | null;            // 유저 이름

    login: (name: string) => void;      // 로기은 함수
    logout: () => void;                 // 로그아웃 함수    
}

const useUserStore = create<UserState>((set) => ({
    // 초기 상태 (비회원 상태)
    isLoggedIn: false,
    userName: null,

    // 로그인 함수
    login: (name: string) => set({ isLoggedIn: true, userName: name }),

    // 로그아웃 함수
    logout: () => set({ isLoggedIn: false, userName: null }),

}))

export default useUserStore;