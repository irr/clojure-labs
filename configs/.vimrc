set guifont=mononoki\ 12
set guioptions-=T
set tabstop=4
set shiftwidth=4
set softtabstop=4
set viminfo=""
set nobackup
set nowritebackup
set noswapfile
set fileformat=unix
set pastetoggle=<F6>
set laststatus=2
set statusline=%02n:%t[%{strlen(&fenc)?&fenc:'none'},%{&ff}]%h%m%r%y%=%c,%l/%L\ %P
set showtabline=1
set expandtab
set number
set paste
retab

execute pathogen#infect()

syntax on
filetype plugin indent on

au VimLeave * if filereadable("~/.vim//.netrwhist")|call delete(".vim/.netrwhist")|endif

vnoremap <C-X> "+x
vnoremap <S-Del> "+x

vnoremap <C-C> "+y
vnoremap <C-Insert> "+y

map <C-V> "+p
map <S-Insert> "+p

cmap <C-V> <C-R>+
cmap <S-Insert> <C-R>+

map <F2> :set fileencoding=utf-8<CR>:set fileformat=unix<CR>:w<CR>
map <F5> :buffers<CR>:buffer<Space>
imap <F8> import pdb;pdb.set_trace()<C-M>
map <F10> :bd<CR>

set t_Co=256

