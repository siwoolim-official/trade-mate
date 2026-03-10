export default function Home() {
    return (
        <main className="flex min-h-screen flex-col items-center justify-center bg-gray-50 p-24">
            <h1 className="text-5xl font-bold text-blue-600 mb-6">Tread Meta</h1>

            <p className="text-sm text-gray-500">(프론트엔드 개발 중입니다...)</p>

            <div>
                <button className="px-6 py-3 bg-blue-600 text-white rounded-lg font-medium hover:bg-blue-700 transition">
                    매매일지 작성하기
                </button>
                <button className="px-6 py-3 bg-white text-blue-600 border border-blue-600 rounded-lg font-medium hover:bg-blue-50 transition">
                    커뮤니티 둘러버기
                </button>
            </div>
        </main>
    );
}